package compiler.models;

import compiler.annotations.CompilerPrinter;

@CompilerPrinter
public record Print(Term value, Location location) implements Executor, Term {

    @Override
    public byte _execute() {

        System.out.println(this.value().toStringCompiler());

        return 0;
    }

    @Override
    public String toStringCompiler() {
        return this.value().toStringCompiler();
    }

    @Override
    public String returnTypeTerm() {
        return "print";
    }
}
