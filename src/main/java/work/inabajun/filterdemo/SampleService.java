package work.inabajun.filterdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleService.class);

    public void execute() {
        LOGGER.info("service");

    }
}
