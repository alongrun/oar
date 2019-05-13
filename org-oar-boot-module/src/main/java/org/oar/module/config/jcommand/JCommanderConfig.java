package org.oar.module.config.jcommand;

import com.beust.jcommander.Parameter;

public class JCommanderConfig {

//    @Parameter(names = "-debug", description = "Debug mode")
//    public boolean debug = false;

    @Parameter(names = "-config",description = "Config parameters")
    public String configjson ="";

}
