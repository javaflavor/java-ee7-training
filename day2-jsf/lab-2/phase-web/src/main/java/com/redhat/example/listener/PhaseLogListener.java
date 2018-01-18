package com.redhat.example.listener;

import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseLogListener implements PhaseListener {
	private static final long serialVersionUID = -9089219318419775549L;
	
	static Logger log = Logger.getLogger(PhaseLogListener.class.getName());

    public void beforePhase(PhaseEvent event) {
    	log.info("### Before "+event.getPhaseId());
    }

    public void afterPhase(PhaseEvent event) {
    	log.info("### After  "+event.getPhaseId());
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
}
