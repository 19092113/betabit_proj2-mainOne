package nl.betabit.betabit;

import nl.betabit.betabit.Data;
import nl.betabit.betabit.StringChecker;
import nl.betabit.betabit.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringCheckerTest {

    private StringChecker stringCheckerUnderTest;

    @BeforeEach
    void setUp() {
        stringCheckerUnderTest = new StringChecker();
        Data.user.add(new User("rowin@hhs.nl","Ester versteeg","Marketing","test"));

    }
    @Test
    void testIsFullName_true() {
        assertTrue(stringCheckerUnderTest.isFullName("Rowin Hartog"));
    }
    @Test
    void testIsFullName_Partly(){
        assertFalse(stringCheckerUnderTest.isFullName("Rowin"));
    }
    @Test
    void testIsFullName_forbidden_characters(){
        assertFalse(stringCheckerUnderTest.isFullName("3244% 9ah"));
    }

    @Test
    void testIsFullName_forbidden_numbers(){
        assertFalse(stringCheckerUnderTest.isFullName(("R0win H4rtog")));
    }
    @Test
    void testIsMail(){
        assertTrue(StringChecker.isValid("rowin@hhs.nl"));
    }
    @Test
    void testIsNotMail(){
        assertFalse(StringChecker.isValid("rowinhhs.nl"));
    }

    @Test
    void userIsNotTaken(){
        assertFalse(StringChecker.alreadyRegistered("rowi3n@hhs.nl"));
    }

    @Test
    void userIsTaken(){
        assertTrue(StringChecker.alreadyRegistered("rowin@hhs.nl"));
    }

}
