package first;

import java.sql.*;
import java.util.Scanner;

public class JDBCTestDeptDMLUpdate {
    public static void main(String[] args) {

        //연결 객체 : 연결 정보를 가진다.
        Connection connection = null;
        // sql을 실행 할 메소드 제공
        Statement statement = null;
        // excuteQuery() 반환타입 -> sekect 의 결과 표를 담는 객체
        ResultSet resultSet = null;
        // Statment -> PreparedStatement : 성능개선
        PreparedStatement preparedStatement = null;

        Scanner scanner = new Scanner(System.in);

        try {
            // 1. 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("드라이버 로드 성공!");

            // 2. 연결
            String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "hr";
            String password = "tiger";

            connection = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("데이터베이스 연결 성공!!!");

            connection.setAutoCommit(false);


            // 사용자에게 정보를 받아 데이터를 수정
            // 10 dev seoul ==> " "
            System.out.println("부서 데이터를 수정합니다");
            System.out.println("10 dev seoul 형식으로 데이터를 입력해주세요");
            String input = scanner.nextLine();

            // String 타입의 배열 String[] 만들기
            String[] inputs = input.split(" ");

            for(String str : inputs){
                System.out.println(str);
            }


            connection.commit();


        } catch (ClassNotFoundException e) {
            System.out.println("드라이브 클래스를 찾지 못함!");
            e.printStackTrace();
        } catch (SQLException e) {
            //System.out.println("데이터베이스 연결 실패!!");
            try {
                connection.rollback();
            } catch (SQLException a) {
                a.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 4. close
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
