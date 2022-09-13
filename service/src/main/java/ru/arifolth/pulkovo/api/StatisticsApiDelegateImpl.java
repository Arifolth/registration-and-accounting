package ru.arifolth.pulkovo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.arifolth.pulkovo.model.Statistics;

@Component
public class StatisticsApiDelegateImpl implements StatisticsApiDelegate {
    @Autowired
    private UserDAO userDAOImpl;

    @Override
    public ResponseEntity<Statistics> getStatistics(Integer reqStatus, Boolean adults) {
        return userDAOImpl.getStatistics(reqStatus, adults);
    }
}
