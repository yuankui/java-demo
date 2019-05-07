package com.yuankui.java.test.javademo.jgit;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ProgressMonitor;

import java.io.File;
import java.io.IOException;

@Slf4j
public class GitTest {
    public static void main(String[] args) throws IOException, GitAPIException {
        CloneCommand cloneCommand = new CloneCommand();
        cloneCommand.setURI("https://github.com/yuankui/java-demo.git");
        cloneCommand.setDirectory(new File("tmp"));

        cloneCommand.setProgressMonitor(new ProgressMonitor() {
            @Override
            public void start(int i) {
                System.out.println("start");
            }

            @Override
            public void beginTask(String s, int i) {
                System.out.println("begin task: " + s +" => " + i);
            }

            @Override
            public void update(int i) {
                System.out.println("update: " + i);
            }

            @Override
            public void endTask() {
                System.out.println("endTask");
                
            }

            @Override
            public boolean isCancelled() {
                return false;
            }
        });
        
        cloneCommand.call();
    }
}
