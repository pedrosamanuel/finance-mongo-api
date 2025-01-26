package com.finance.repository;

import com.finance.generic.UserDependent.UserDependentRepository;
import com.finance.model.Expense;
import com.finance.payload.dto.ExpenseSummaryDto;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends UserDependentRepository<Expense, String> {
    @Aggregation(pipeline = {
            "{ $match: { userId: ?0 } }",
            "{ $match: { $expr: { $and: [ { $eq: [ { $month: '$date' }, ?1 ] }, { $eq: [ { $year: '$date' }, ?2 ] } ] } } }",
            "{ $group: { _id: '$categoryId', totalAmount: { $sum: '$amount' } } }"
    })
    List<ExpenseSummaryDto> getExpenseByCategory(String userId, int month, int year);
}
