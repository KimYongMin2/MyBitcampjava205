package first;

import java.sql.*;
import java.util.Scanner;

public class JDBCTestDeptDMLDel {
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


            System.out.println("부서정보 삭제를 시작합니다");
            System.out.print("부서 번호를 입력해 주세요 : ");
            String deptno = scanner.nextLine();

            String sql = "delete from dept01 where deptno = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(deptno));

            int result = preparedStatement.executeUpdate();
            if (result>0){
                System.out.println(result + "개 행이 삭제되었습니다.");
            }else {
                System.out.println("조건에 맞는 데이터가 존재하지 않습니다.");
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
