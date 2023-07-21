package test.effects.option;

import patternmatching.effects.option.None;
import patternmatching.effects.option.Option;
import patternmatching.effects.option.Some;

public class Functions {

    static Option<Company> employer(Person person){
        return person.name() == "Naveen" ?  new None() : new Some<Company>(new Company("MS"));
    }

    static  Option<Person> CTO(Company company){
        return company.name() == "MS"?  new Some<Person>(new Person("KS")) :  new None();
    }

}
