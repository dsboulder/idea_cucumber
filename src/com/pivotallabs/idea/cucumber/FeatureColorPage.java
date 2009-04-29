package com.pivotallabs.idea.cucumber;

import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.NonNls;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: pivotal
 * Date: Apr 28, 2009
 * Time: 4:01:27 PM
 * To change this template use File | Settings | File Templates.
 */

final class FeatureColorPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] EMPTY_ATTRIBUTES_DESCRIPTOR_ARRAY = new AttributesDescriptor[] {};
    private static final ColorDescriptor[] EMPTY_COLOR_DESCRIPTOR_ARRAY = new ColorDescriptor[] {};

    private final Set<AttributesDescriptor> attributeDescriptors = new HashSet<AttributesDescriptor>();

    public FeatureColorPage() {
        attributeDescriptors.add(new AttributesDescriptor("Comment", FeatureHighligherColors.COMMENT));
        attributeDescriptors.add(new AttributesDescriptor("String", FeatureHighligherColors.STRING));
    }

    @Nullable
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return attributeDescriptors.toArray(EMPTY_ATTRIBUTES_DESCRIPTOR_ARRAY);
    }

    @NotNull
    public ColorDescriptor[] getColorDescriptors() {
        return EMPTY_COLOR_DESCRIPTOR_ARRAY;
    }

    @NonNls
    @NotNull
    public String getDemoText() {
        return "Feature: Addition\n" +
            "  In order to avoid silly mistakes\n" +
            "  As a math idiot\n" +
            "  I want to be told the sum of two numbers\n" +
            "  # This is gonna be sweet!" +
            "\n" +
            "  Scenario Outline: Add two numbers\n" +
            "    Given I have entered \"5\" into the calculator\n" +
            "    And I have entered \"six\" into the calculator";
    }

    @NotNull
    public String getDisplayName() {
        return "Cucumber Feature";
    }

    @NotNull
    public SyntaxHighlighter getHighlighter() {
      
        return ((CucumberFeatureLanguage)CucumberSupportLoader.getInstance().getFileType().getLanguage()).getSyntaxHighlighter(null, null);
    }

    @Nullable
    public Icon getIcon() {
        return CucumberSupportLoader.getInstance().getFileType().getIcon();
    }

}

