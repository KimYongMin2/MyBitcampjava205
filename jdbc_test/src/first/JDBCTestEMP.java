package first;

import java.sql.*;

public class JDBCTestEMP {
    public static void main(String[] args) {

        //연결 객체 : 연결 정보를 가진다.
        Connection connection = null;
        // sql을 실행 할 메소드 제공
        Statement statement = null;
        // excuteQuery() 반환타입 -> sekect 의 결과 표를 담는 객체
        ResultSet resultSet = null;
        // Statment -> PreparedStatement : 성능개선
        PreparedStatement preparedStatement = null;

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

            // 3. sql처리
            // 사원번호, 사원이름, 직급, sal, 부서이름, 부서위치

            // 1. Statement
            statement = connection.createStatement();
            // 2. sql
            String sql = "select e.empno, e.ename, e.job, e.sal, d.dname, d.loc  from emp e, dept d where e.deptno=d.deptno";
            // 3. ResultSet 객체로 데이터 받기
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2));
            }
            // 4. 출력

        } catch (ClassNotFoundException e) {
            System.out.println("드라이브 클래스를 찾지 못함!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패!!");
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
