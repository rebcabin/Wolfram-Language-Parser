/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.psi.impl.source.tree.java;

import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiExpression;
import com.intellij.psi.PsiType;
import com.intellij.psi.impl.source.Constants;
import org.jetbrains.annotations.NotNull;

public class PsiEmptyExpressionImpl extends ExpressionPsiElement implements PsiExpression{
  public PsiEmptyExpressionImpl() {
    super(Constants.EMPTY_EXPRESSION);
  }

  @Override
  public PsiType getType() {
    return null;
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof JavaElementVisitor) {
      ((JavaElementVisitor)visitor).visitExpression(this);
    }
    else {
      visitor.visitElement(this);
    }
  }

  public String toString() {
    return "PsiExpression(empty)";
  }
}
