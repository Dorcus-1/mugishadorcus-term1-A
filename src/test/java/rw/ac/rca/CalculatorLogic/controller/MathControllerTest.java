package rw.ac.rca.CalculatorLogic.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rw.ac.rca.CalculatorLogic.dtos.DoMathRequestDto;
import rw.ac.rca.CalculatorLogic.payload.ApiResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void doMathOperation_Success(){
        DoMathRequestDto dto = new DoMathRequestDto(2, 5, "+");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/do_math",dto,ApiResponse.class);

        assertEquals(200, response.getStatusCode().value());
    }
    @Test
    public void doMathOperation_Addition(){
        DoMathRequestDto dto = new DoMathRequestDto(2, 5, "+");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/do_math",dto,ApiResponse.class);

        assertEquals(7.0, response.getBody().getData());
    }
    @Test
    public void doMathOperation_Subtraction(){
        DoMathRequestDto dto = new DoMathRequestDto(5, 2, "-");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/do_math",dto,ApiResponse.class);

        assertEquals(3.0, response.getBody().getData());
    }
    @Test
    public void doMathOperation_Division(){
        DoMathRequestDto dto = new DoMathRequestDto(6, 2, "/");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/do_math",dto,ApiResponse.class);

        assertEquals(3.0, response.getBody().getData());
    }
    @Test
    public void doMathOperation_Multiplication(){
        DoMathRequestDto dto = new DoMathRequestDto(6, 2, "*");

        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/do_math",dto,ApiResponse.class);

        assertEquals(12.0, response.getBody().getData());
    }
}
