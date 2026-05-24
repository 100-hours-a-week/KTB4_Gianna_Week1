package org.example;
import java.util.Scanner;

public class IO {
    static Scanner sc = new Scanner(System.in);

    static void printOpenStore(){
        System.out.println("장사를 시작하겠습니다.");
    }

    static void printIntro() {
        System.out.println("----- <<KTB 로또 키오스크>> -----");
        System.out.println("안녕하십니까. 어떤 기능을 사용하시겠습니까?");
        System.out.print("1.스피또 발행\n2.자동 로또 발행 (현재 개발 중 - 사용 불가)\n3.종료\n");
    }

    static void printResult(StringBuilder result){
        System.out.println(result);
        System.out.println("===================");

    }

    static void printBlockedOption(){
        System.out.println("해당 기능은 현재 개발 중에 있습니다.\n다른 옵션을 선택해주세요.\n죄송합니다.");
    }

    static void printCountOfPeople(int count){
        System.out.printf("%d명의 사람이 스피또를 뽑습니다.\n", count);
    }

    static void printQuit(){
        System.out.println("\n----- <<프로그램 종료>> -----");
        System.out.println("이용해주셔서 감사합니다.\n좋은 하루 보내세요!");
    }

    static String getOption() {
        System.out.print(">>> ");
        return sc.next();
    }
}