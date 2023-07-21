package test.effects.option;

import org.testng.annotations.Test;

import static test.effects.option.Functions.employer;

public class TestOption {

    @Test
    public void testChaining(){
        Person naveen = new Person("Naveen");
        Person satya = new Person("Satya");

        System.out.println(lengthOfCTOOfEmployer(naveen));
        System.out.println(lengthOfCTOOfEmployer(satya));
    }

    private static Integer lengthOfCTOOfEmployer(Person naveen) {
        return employer(naveen).flatMap(Functions::CTO).map(Person::name).map(String::length).match( 0, x -> x);
    }
}
