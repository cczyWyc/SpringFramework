package com.cczywyc.springfx.aop;

/**
 * proxy {@link EchoService} implements
 *
 * @author wangyc
 */
public class ProxyEchoService implements EchoService{

    /** echo service */
    private EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        long startTime = System.currentTimeMillis();
        String result = echoService.echo(message);
        long castTime = System.currentTimeMillis() - startTime;
        System.out.println("The function echo exec time is:" + castTime + "ms.");
        return result;
    }
}
