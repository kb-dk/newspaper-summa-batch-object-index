package sboi;

import dk.statsbiblioteket.newspaper.processmonitor.datasources.Batch;
import dk.statsbiblioteket.newspaper.processmonitor.datasources.EventID;

import java.util.Date;
import java.util.List;

public class SBOILibrary {



    public List<Batch> getBatches(List<String> successfulPreEvents, List<String> minusSuccessfulEvent){
        return null;
    }

    public void registerEvent(Long batchID, Integer runNr, EventID eventID, String agent, Date timestamp, String details, boolean success){

    }


    public Batch getBatch(Long batchID, Integer runNr) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
