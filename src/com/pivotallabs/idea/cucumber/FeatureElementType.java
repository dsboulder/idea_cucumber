package com.pivotallabs.idea.cucumber;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.text.MessageFormat;

/**
 * Created by IntelliJ IDEA.
 * User: stevend
 * Date: Apr 27, 2009
 * Time: 9:50:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class FeatureElementType extends IElementType {
    private final IElementType parsedType;

    public FeatureElementType(@NotNull @NonNls String debugName, IElementType parsedType) {
        super(debugName, CucumberSupportLoader.getInstance().getFileType().getLanguage());
        this.parsedType = parsedType;
    }

    public FeatureElementType(@NotNull @NonNls String debugName) {
        this(debugName, null);
    }

    public IElementType getParsedType() {
        return parsedType != null ? parsedType : this;
    }

    @SuppressWarnings({"HardCodedStringLiteral"})
    public String toString() {
      return MessageFormat.format("JFlex:{0}", super.toString());
    }
}