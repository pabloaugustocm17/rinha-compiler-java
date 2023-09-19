package compiler.models;

public record File(
        String name,
        Term expression,
        Location location
) {
}
