package com.allendowney.thinkdast;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class ListClientExampleTest {

    @Test
    public  void ListClientExampleTest(){
        ListClientExample test = new ListClientExample();
        List testList = test.getList();
        assertThat(testList, instanceOf(List.class));
    }
}
