package com.mechanitis.demo.sense.service;

import java.util.Arrays;

public class Monitor {
    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                     .map(processHandle -> processHandle.info())
                     .filter(info -> info.user().filter(s -> s.equals("trishagee")).isPresent())
                     .filter(info -> info.command().filter(s -> s.contains("java")).isPresent())
                     .flatMap(info -> info.arguments().stream())
                     .flatMap(arguments -> Arrays.stream(arguments))
                     .filter(s -> s.startsWith("com.mechanitis"))
                     .forEach(processHandle -> System.out.println(processHandle));

        final long pid = ProcessHandle.current().pid();
    }
}
