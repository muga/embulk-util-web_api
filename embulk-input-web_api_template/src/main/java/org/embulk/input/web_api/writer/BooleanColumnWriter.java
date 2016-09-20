package org.embulk.input.web_api.writer;

import com.fasterxml.jackson.databind.JsonNode;
import org.embulk.spi.Column;
import org.embulk.spi.PageBuilder;

public class BooleanColumnWriter
        extends AbstractColumnWriter
{
    public BooleanColumnWriter(Column column)
    {
        super(column);
    }

    @Override
    public void write(JsonNode v, PageBuilder to)
    {
        if (v == null || v.isNull()) {
            to.setNull(column);
        }
        else {
            to.setBoolean(column, v.booleanValue());
        }
    }
}
