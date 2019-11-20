package commands

import groovyjarjarpicocli.CommandLine
import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

class hello {

    // 命令用途
    @Usage("Say Hello")
    // 当前是crash命令
    @Command
    def main(InvocationContext context) {

        // groovy 的方法和变量生命关键字为def
        def bootVersion = context.attributes['spring.boot.version'];
        def springVersion = context.attributes['spring.version'];

        return "Hello Elijah,your Spring Boot version is " + bootVersion
        + ", your Spring Framework version is " + springVersion

    }
}

