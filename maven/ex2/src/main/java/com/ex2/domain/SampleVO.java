/* https://doublesprogramming.tistory.com/204 */

package com.ex2.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ajax/test")
public class SampleVO {

    private Integer sampleNo;
    private String firstName;
    private String lastName;

    public Integer getSampleNo() {
        return sampleNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSampleNo(Integer sampleNo) {
        this.sampleNo = sampleNo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "SampleVO{" +
                "sampleNo=" + sampleNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @RequestMapping("/sendVO")
    public SampleVO sendVO() {
        SampleVO sp = new SampleVO();
        sp.setSampleNo(1);
        sp.setFirstName("ff");
        sp.setLastName("ll");

        return sp;
    }

    @RequestMapping("/sendList")
    public List<SampleVO> sendList() {
        List<SampleVO> samples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SampleVO tmp = new SampleVO();
            tmp.setSampleNo(i + 1);
            tmp.setFirstName("박");
            tmp.setLastName("지호" + (i + 1));

            samples.add(tmp);
        }
        return samples;
    }

    @RequestMapping("/sendMap")
    public Map<Integer, SampleVO> sendMap() {
        Map<Integer, SampleVO> sampleMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            SampleVO tmp = new SampleVO();
            tmp.setSampleNo(i + 1);
            tmp.setFirstName("박");
            tmp.setLastName("지호" + (i + 1));

            sampleMap.put(i, tmp);
        }
        return sampleMap;
    }

    @RequestMapping("/sendErrorAuth")
    public ResponseEntity<Void> sendListAuth() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
