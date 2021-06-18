package first;

import java.sql.*;

public class JDBCTest {
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
            statement = connection.createStatement();

            int dno = 10;

            String sqlSelect = "Select * from dept where deptno = "+dno+ "order by dname";

            resultSet = statement.executeQuery(sqlSelect);

            // resultSet.next() -> 다음행의 존재 유뮤 확인
            while(resultSet.next()) {
                int deptno = resultSet.getInt("deptno");
                System.out.print(deptno + "\t");
                String dname = resultSet.getString("dname");
                System.out.print(dname + "\t");
                String loc = resultSet.getString("loc");
                System.out.print(loc + "\t");
                System.out.println();
            }


            ///////////////////////////////////////////////////////////////////////////////////
            // PreparedStatement -> sql 먼저 등록 -> 매개변수처럼 ? 를 이용해서 나중에 변수를 바인딩
            String sqlSelect2 = "Select * from dept where deptno = ? ";
            preparedStatement = connection.prepareStatement(sqlSelect2);
            // 변수 ? 에 데이터 바인딩
            preparedStatement.setInt(1, 10);
            resultSet = preparedStatement.executeQuery();

            System.out.println("==========================================");
            while(resultSet.next()) {
                int deptno = resultSet.getInt("deptno");
                System.out.print(deptno + "\t");
                String dname = resultSet.getString("dname");
                System.out.print(dname + "\t");
                String loc = resultSet.getString("loc");
                System.out.print(loc + "\t");
                System.out.println();
            }


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
