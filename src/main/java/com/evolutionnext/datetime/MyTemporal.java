package com.evolutionnext.datetime;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

public class MyTemporal implements TemporalQuery<LocalDate> {
    @Override
    public LocalDate queryFrom(TemporalAccessor temporal) {
        return LocalDate.from(temporal);
    }
}
