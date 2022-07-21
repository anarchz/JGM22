package com.epam.ld.module2.testing;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;

public class WriteToFileExtention implements InvocationInterceptor {
    File file = new File("log.txt");

    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
                                    ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws Throwable {
        try{
            invocation.proceed();
        } finally {
            String testClassName = invocationContext.getTargetClass().getSimpleName();
            String testMethodName = invocationContext.getExecutable().getName();
            Files.writeString(file.toPath(),
                    String.format("Executed test dlass: %s, test method: %s", testClassName, testMethodName));
        }
    }
}
