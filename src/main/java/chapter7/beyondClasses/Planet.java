package chapter7.beyondClasses;

/****************************************************************************
 * <b>Title:</b> Planet.java <br>
 * <b>Project:</b> Brian.Java-OCP-Certification <br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2022 <br>
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author Brian Knight
 * @version 1.x
 * @since Jan 4, 2024 <b>updates:</b>
 * 
 ****************************************************************************/

public abstract sealed class Planet {}

//non-sealed class Venus {}
non-sealed class Mars extends Planet {}
//non-sealed class Mercury {}
//abstract non-sealed class Earth {}

