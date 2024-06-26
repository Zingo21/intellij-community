// Copyright 2000-2024 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package com.intellij.codeInsight.template.postfix.templates;

import com.intellij.codeInsight.template.Template;
import com.intellij.codeInsight.template.impl.TextExpression;
import com.intellij.codeInsight.template.postfix.util.JavaPostfixTemplatesUtils;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiExpression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ForDescendingPostfixTemplate extends ForIndexedPostfixTemplate {
  public ForDescendingPostfixTemplate(@NotNull JavaPostfixTemplateProvider provider) {
    super("forr", "for ($type$ $index$ = $bound$; $index$ $sign$ 0; $index$--) {\n$END$\n}",
          "for (int i = expr.length-1; i >= 0; i--)", provider);
  }

  @Override
  protected void addTemplateVariables(@NotNull PsiElement element, @NotNull Template template) {
    super.addTemplateVariables(element, template);
    template.addVariable("sign", new TextExpression(getSign(element)), false);
  }

  @Override
  protected @Nullable String getExpressionBound(@NotNull PsiExpression expr) {
    String result = super.getExpressionBound(expr);
    return result == null || JavaPostfixTemplatesUtils.isNumber(expr.getType()) ? result : result + " - 1";
  }

  private static @NotNull String getSign(@NotNull PsiElement element) {
    return element instanceof PsiExpression && JavaPostfixTemplatesUtils.isNumber(((PsiExpression)element).getType()) ? ">" : ">=";
  }
}