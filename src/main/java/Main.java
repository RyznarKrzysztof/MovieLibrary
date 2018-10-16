import java.io.*;
import java.lang.reflect.Array;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import People.Actor;
import People.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        //ObjectMapper provides functionality for reading and writing JSON, either to and from basic
        //POJOs (Plain Old Java Objects), or to and from a general-purpose
        //JSON Tree Model (JsonNode), as well as related functionality for performing conversions.

        ClassLoader classLoader = new Main().getClass().getClassLoader();
        File file = new File(classLoader.getResource("MoviesJSON").getFile());

        ArrayList<Movie> movies = objectMapper.readValue(file, new TypeReference<List<Movie>>(){});
        //readValue - Method to deserialize JSON content from given file into given Java type.


        for(Movie m : movies){
            System.out.println("Title = " + m.getTitle());
            System.out.println("Director = " + m.getDirector());
            System.out.println("Year = " + m.getYear());
            System.out.println("Genre = " + m.getGenre());
            System.out.print("Actors: ");
            for(int i = 0; i<m.getActors().length; i++){
                if(i == m.getActors().length - 1){
                    System.out.println(m.getActors()[i]);
                }else {
                    System.out.print(m.getActors()[i] + ", ");
                }
            }
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by actor - press 1");
        System.out.println("Search by genre and date range - press 2");
        int n = scanner.nextInt();
        scanner.nextLine();
        if(n == 1){
            System.out.println("Please provide Actor's first name");
            String name = scanner.nextLine();
            System.out.println("Please provide Actor's second name");
            String surname = scanner.nextLine();
            for(Movie m : movies){
                for(int i = 0; i < m.getActors().length; i++){
                    if(m.getActors()[i].getName().equals(name) && m.getActors()[i].getSurname().equals(surname)){
                        System.out.println(m.getTitle());
                    }
                }
            }
        }else if(n == 2){
            System.out.println("Please provide genre");
            String genre = scanner.nextLine();
            System.out.println("Please provide min");
            int min = scanner.nextInt();
            System.out.println("Please provide max");
            int max = scanner.nextInt();
            for(Movie m : movies){
                if(m.getGenre().equals(genre) && m.getYear() >= min && m.getYear() <= max){
                    System.out.println(m.getTitle());
                }
            }
        }else{
            System.out.print("Incorrect number");
        }
    }
}