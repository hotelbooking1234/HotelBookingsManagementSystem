package com.cg.hbm.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.hbm.entities.Transactions;
import com.cg.hbm.repository.TransactionsRepository;

class TransactionsServiceImplTest {
	@InjectMocks   // use on which class to test
	TransactionsServiceImpl transactionsServiceImpl;
	
	@Mock
	TransactionsRepository transactionsRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void doInit()
	{
		MockitoAnnotations.initMocks(this);
	}


	@Test
	@DisplayName("Test case to test insertion of Course when input values are valid")
	void testAddTransactions() {
		// sample input 
		
		Transactions sampleInput = new Transactions(17000, LocalDate.of(2023,01,01));	

		// expected output 
		Transactions actualOutput  = new Transactions( 17000,LocalDate.of(2023,01,01));	
		actualOutput.setTransactionId(0);
		actualOutput.setTransactionId(null);
		
		Transactions expectedOutput = new Transactions( 17000,LocalDate.of(2023,01,01));
		expectedOutput.setTransactionId(0);
		expectedOutput.setTransactionId(null);
		
		// call actual method and store actual result : actual output
		
		when(transactionsRepository.save(sampleInput)).thenReturn(actualOutput);
		
		// compare actual output with expected output
				assertEquals(actualOutput, expectedOutput);
				
			}
	@Test
	@DisplayName("Test case to test insertion of Course when input values are invalid")
	void testAddTransactions2() {
		Transactions sampleInput = new Transactions(17000,LocalDate.of(2023,01,01));
		
		// call actual method and store actual result : actual output
		
				when(transactionsRepository.save(sampleInput)).thenThrow(NullPointerException.class);
				
				
	}
}
