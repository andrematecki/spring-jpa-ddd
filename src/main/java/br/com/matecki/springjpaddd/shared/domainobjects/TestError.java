package br.com.matecki.springjpaddd.shared.domainobjects;

public class TestError extends Exception{
    public TestError() {
        super("Test executed with error");
    }
}
