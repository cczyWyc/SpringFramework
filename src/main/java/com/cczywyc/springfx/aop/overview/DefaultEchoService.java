package com.cczywyc.springfx.aop.overview;

/**
 * default {@link EchoService} implements
 *
 * @author wangyc
 */
public class DefaultEchoService implements EchoService{
    @Override
    public String echo(String message) {
        System.out.println(message);
        return "[ECHO ]" + message;
    }
}
