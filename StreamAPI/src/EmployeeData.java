import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"马化腾",6000.38));
        list.add(new Employee(1002,"马云",6320.38));
        list.add(new Employee(1003,"刘强东",3000.38));
        list.add(new Employee(1004,"雷军",4000.38));
        list.add(new Employee(1005,"李彦宏",6500.38));
        list.add(new Employee(1006,"任正非",6700.38));
        list.add(new Employee(1007,"比尔盖茨",9000.38));

        return list;
    }
}
