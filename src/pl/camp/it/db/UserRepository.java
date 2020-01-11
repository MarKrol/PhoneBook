package pl.camp.it.db;

import pl.camp.it.user.Business;
import pl.camp.it.user.Individual;
import pl.camp.it.user.UserStructure;

public class UserRepository{

    private final int size = 15;

    private UserStructure[] userStructures = new UserStructure[size];

    private UserRepository(){
        this.userStructures[0] = new Individual("Fredry", "34a", "36040", "Kraków",
                "małopolskie", "Polska","+4812123456789",
                "Michał", "Gac");
        this.userStructures[1] = new Business("Point","21c", "31416", "Nowy Jork",
                "Nowy Jork","USA","+12334565453334","Construction LI",
                "PL4566722222");
        this.userStructures[2] = new Individual("Mała", "34a", "36040", "Kraków",
                "małopolskie", "Polska","+4812123456789",
                "Zenek", "Gac");
        this.userStructures[3] = new Business("Point","21c", "31416", "Chicago",
                "Illinois","USA","+12334565453334","Construction LI",
                "PL4566722222");

    }

    private static UserRepository userRepository = new UserRepository();

    public UserStructure[] getUserStructures() {
        return userStructures;
    }

    public int getSize() {
        return size;
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

}
