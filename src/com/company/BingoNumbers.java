package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BingoNumbers
{
    Set<Integer> calledNumbers = new HashSet<>();

    public static void main(String[] args)
    {
        BingoNumbers bingoNumbers = new BingoNumbers();
        bingoNumbers.run();


    }

    private void run()
    {

        Scanner in = new Scanner(System.in);
        String command;
        String commandLine;

        System.out.println("Please enter one of the following commands: ");
        System.out.println("Call <1-75> to add called numbers");
        System.out.println("Called to print called numbers");
        System.out.println("Verify <1-75> to verify called or  not");
        System.out.println("Challenge <1-75> to to remove from called numbers");
        System.out.println("Bingo to reset the game");

        do
        {
            System.out.println("What is your command?");
            commandLine = in.nextLine();
            String[] commands = commandLine.split(" ");
            command = commands[0].toUpperCase();
            try
            {
                if (command.equals("CALL") ||
                        command.equals("CALLED") ||
                        command.equals("VERIFY") ||
                        command.equals("CHALLENGE") ||
                        command.equals("BINGO"))
                {
                    if (command.equals("CALL") && commands.length == 2)
                    {
                        try
                        {
                            int calledNumber = Integer.parseInt(commands[1]);
                            callNumber(calledNumber);
                        } catch (Exception e)
                        {
                            System.out.println("Invalid");
                        }
                    }
                    if (command.equals("CALLED"))
                    {
                        try
                        {
                            for (int values : calledNumbers)
                            {
                                System.out.println(values);
                            }
                        } catch (Exception e)
                        {
                            System.out.println("Invalid");
                        }
                    }
                    if (command.equals("VERIFY") && commands.length == 2)
                    {
                        try
                        {
                            int calledNumber = Integer.parseInt(commands[1]);
                            verifyNumber(calledNumber);
                        } catch (Exception e)
                        {
                            System.out.println("Invalid");
                        }
                    }
                    if (command.equals("CHALLENGE") && commands.length == 2)
                    {
                        try
                        {
                            int challengedNumber = Integer.parseInt(commands[1]);
                            removeNumber(challengedNumber);
                        } catch (Exception e)
                        {
                            System.out.println("Invalid");
                        }
                    }
                    if (command.equals("BINGO"))
                    {
                        try
                        {
                            if (calledNumbers.size() >= 4)
                            {
                                calledNumbers.clear();
                                System.out.println("Congratulations you win a fruit cake!");
                            } else if (calledNumbers.size() < 4)
                            {
                                System.out.println("Cheater!");
                            }
                        } catch (Exception e)
                        {
                            System.out.println("Invalid");
                        }
                    }
                }
                System.out.println("Invalid Command");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        while (!command.equals("EXIT"));
        {
            try
            {
                System.out.println("Thanks for Playing!");
            }
            catch (Exception e)
            {
                System.out.println("Invalid");
            }
        }
    }

    private void callNumber(int number)
    {
        if (number >= 1 && number <= 75)
        {
            if (calledNumbers.contains(number))
            {
                System.out.println("Already Called!");
            } else
            {
                System.out.println("Added " + number);
                calledNumbers.add(number);
            }
        } else
        {
            System.out.println("Only numbers 1 to 75");
        }
    }

    private void verifyNumber(int number)
    {
        if (number >= 1 && number <= 75)
        {
            if (calledNumbers.contains(number))
            {
                System.out.println(number + " Already Called! ");
            } else
            {
                System.out.println(number + " Not Called Yet! ");
            }
        } else
        {
            System.out.println("Only numbers 1 to 75");
        }

    }

    private void removeNumber(int number)
    {
        if (number >= 1 && number <= 75)
        {
            if (calledNumbers.contains(number))
            {
                calledNumbers.remove(number);
            } else
            {
                System.out.println(number + " Not Called Yet! ");
            }
        } else
        {
            System.out.println("Only numbers 1 to 75");
        }

    }
}
