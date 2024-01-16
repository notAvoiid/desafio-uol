package com.imrzoom.desafiouol.infra;

import com.imrzoom.desafiouol.exceptions.NoSuchElementException;
import com.imrzoom.desafiouol.model.GroupType;
import com.imrzoom.desafiouol.service.CodenameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CodenameHandler {

    @Autowired
    private CodenameService service;

    public String findCodename(GroupType groupType) {
        if(groupType == GroupType.AVENGERS){
            String firstMatch = service.getAvengersCodenameList().stream().findFirst().orElseThrow(NoSuchElementException::new);
            this.service.getAvengersCodenameList().remove(firstMatch);
            return firstMatch;
        }
        String firstMatch = service.getJusticeLeagueList().stream().findFirst().orElseThrow(NoSuchElementException::new);
        this.service.getJusticeLeagueList().remove(firstMatch);
        return firstMatch;
    }
}
