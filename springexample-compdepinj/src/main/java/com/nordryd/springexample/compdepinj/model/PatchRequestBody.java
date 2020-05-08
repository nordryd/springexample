package com.nordryd.springexample.compdepinj.model;

/**
 * <p>
 * Example request body for a PATCH op.
 * </p>
 *
 * @author Nordryd
 */
public class PatchRequestBody
{
    private final String op, path, value;

    public PatchRequestBody(final String op, final String path, final String value) {
        this.op = op;
        this.path = path;
        this.value = value;
    }

    public String getOp() {
        return op;
    }

    public String getPath() {
        return path;
    }

    public String getValue() {
        return value;
    }
}
