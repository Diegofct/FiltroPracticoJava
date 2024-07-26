package com.filtrojava;

import java.util.Scanner;

import Menu.MainMenu;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu(scanner);
        mainMenu.Start();
    }
}