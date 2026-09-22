package chapter02.chicken;

public class InvalidGradeException extends IllegalArgumentException{
    public InvalidGradeException(String s) {
        super("해당 등급이 없습니다: "+s);
    }
}
