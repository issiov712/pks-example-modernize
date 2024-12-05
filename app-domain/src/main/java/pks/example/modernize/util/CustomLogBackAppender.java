package pks.example.modernize.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
// import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.ConsoleAppender;
import lombok.Getter;
import lombok.Setter;


/**
 * <p>This CustomLogBackAppender works, for what it is.  The better way to rewrite the message is to use a custom encoder.
 * This shows how we can just write a normal appender and grab logging event and then spool them into a database in a particular 
 * format.  There is also an existing database appender that uses three (3) tables for the types of events. ( See: 
 * <a href="https://logback.qos.ch/manual/appenders.html#DBAppender">https://logback.qos.ch/manual/appenders.html#DBAppender</a> )</p>
 * 
 * <p>This is the correct way to intercept the logging event and send it to a different logging sink using the logging event as already defined.</p>
 * 
 * <p>To configure...
 * <pre>{@code
 *   <import class="pks.example.modernize.util.CustomLogBackAppender"/>
 *
 *   <appender name="STDOUT" class="CustomLogBackAppender">
 *      <encoder class="PatternLayoutEncoder">
 *        <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} -%kvp- %msg%n</pattern>
 *      </encoder>
 *      <prefix>CUSTOM </prefix>
 *    </appender>
 * }</pre>
 */
@Getter @Setter
public class CustomLogBackAppender extends ConsoleAppender<ILoggingEvent> {

    private String prefix;

    /*
     * Way too much moving bytes around in formatting to be quick.
     */
    @Override
    protected void append(final ILoggingEvent event) {
        System.out.print(prefix + " " + new String(super.encoder.encode(event)));
    }

}
