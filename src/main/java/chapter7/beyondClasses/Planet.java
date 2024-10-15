package chapter7.beyondClasses;

public abstract sealed class Planet {}

//non-sealed class Venus {}
non-sealed class Mars extends Planet {}
//non-sealed class Mercury {}
//abstract non-sealed class Earth {}
//class Saturn extends Planet{} // must be sealed, non-sealed, or final

class Jupiter {}