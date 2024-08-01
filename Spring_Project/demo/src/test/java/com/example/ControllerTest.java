package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

public class ControllerTest {
    private Database databaseMock;
    private Controller controller;

    private static Stream<Arguments> getEmployeeRankAsPerParametersMethodSource() {
        return Stream.of(
                Arguments.of(-10, "Intern"),
                Arguments.of(100, "Junior"),
                Arguments.of(1001, "Principal"));
    }

    @BeforeEach
    public void setup() {
        databaseMock = mock(Database.class);
        controller = new Controller(databaseMock);
        System.out.println("Before--------------------------------------------------");
    }

    @Test
    public void getEmpployeeByNameShouldReturnEmployeeIfFound() {
        Employee employeeMock = new Employee("ABC", 1000);
        when(databaseMock.getEmployeeOne("ABC")).thenReturn(employeeMock);
        assertTrue(controller.getEmployeeByName("ABC").equals(employeeMock));
    }

    @Test
    public void getEmpployeeByNameShouldReturnNullIfNotFound() {
        when(databaseMock.getEmployeeOne("PQR")).thenReturn(null);
        assertTrue(controller.getEmployeeByName("PQR") == null);
    }

    @Test
    public void isEmployeePresentShouldReturnTrueIfEmployeeFound() {
        Employee employeeMock = new Employee("ABC", 1000);
        when(databaseMock.getEmployeeOne("ABC")).thenReturn(employeeMock);
        assertTrue(controller.isEmployeePresent("ABC"));
    }

    @Test
    public void isEmployeePresentShouldReturnFalseIfEmployeeNotFound() {
        when(databaseMock.getEmployeeOne("PQR")).thenReturn(null);
        assertFalse(controller.isEmployeePresent("PQR"));
    }

    @ParameterizedTest
    @MethodSource("getEmployeeRankAsPerParametersMethodSource")
    public void getEmployeeRankAsPerParameters(Integer salary, String rank) {
        System.out.println("Check");
        assertTrue(new Controller(null).getEmployeeRank(salary) == rank);
    }
}
