package pl.ds.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class Controller {

    private String name;
    private String processorType;
    private String majorRev;
    private String minorRev;
    private String description;
    private String redundancyInfo;
    private String security;
    private String safetyInfo;
    private List<DataType> dataTypes;
    private List<Module> modules;
    private List<AddOnInstructionDefinition> addOnInstructionDefinitions;
    private List<Tag> tags;
    private List<Program> programs;
    private List<Task> tasks;
    private String cst;
    private String wallClockTime;
    private List<Trend> trends;
    private String dataLogs;
    private String timeSynchronize;
    private List<EthernetPort> ethernetPorts;

    public Controller() {
    }

    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "ProcessorType")
    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    @XmlAttribute(name = "MajorRev")
    public String getMajorRev() {
        return majorRev;
    }

    public void setMajorRev(String majorRev) {
        this.majorRev = majorRev;
    }

    @XmlAttribute(name = "MinorRev")
    public String getMinorRev() {
        return minorRev;
    }

    public void setMinorRev(String minorRev) {
        this.minorRev = minorRev;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "RedundancyInfo")
    public String getRedundancyInfo() {
        return redundancyInfo;
    }

    public void setRedundancyInfo(String redundancyInfo) {
        this.redundancyInfo = redundancyInfo;
    }

    @XmlElement(name = "Security")
    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    @XmlElement(name = "SafetyInfo")
    public String getSafetyInfo() {
        return safetyInfo;
    }

    public void setSafetyInfo(String safetyInfo) {
        this.safetyInfo = safetyInfo;
    }

    @XmlElement(name = "DataType")
    @XmlElementWrapper(name = "DataTypes")
    public List<DataType> getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(List<DataType> dataTypes) {
        this.dataTypes = dataTypes;
    }

    @XmlElement(name = "Module")
    @XmlElementWrapper(name = "Modules")
    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @XmlElement(name = "AddOnInstructionDefinition")
    @XmlElementWrapper(name = "AddOnInstructionDefinitions")
    public List<AddOnInstructionDefinition> getAddOnInstructionDefinitions() {
        return addOnInstructionDefinitions;
    }

    public void setAddOnInstructionDefinitions(List<AddOnInstructionDefinition> addOnInstructionDefinitions) {
        this.addOnInstructionDefinitions = addOnInstructionDefinitions;
    }

    @XmlElement(name = "Tag")
    @XmlElementWrapper(name = "Tags")
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @XmlElement(name = "Program")
    @XmlElementWrapper(name = "Programs")
    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @XmlElement(name = "Task")
    @XmlElementWrapper(name = "Tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @XmlElement(name = "CST")
    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    @XmlElement(name = "WallClockTime")
    public String getWallClockTime() {
        return wallClockTime;
    }

    public void setWallClockTime(String wallClockTime) {
        this.wallClockTime = wallClockTime;
    }

    @XmlElement(name = "Trend")
    @XmlElementWrapper(name = "Trends")
    public List<Trend> getTrends() {
        return trends;
    }

    public void setTrends(List<Trend> trends) {
        this.trends = trends;
    }

    @XmlElement(name = "DataLogs")
    public String getDataLogs() {
        return dataLogs;
    }

    public void setDataLogs(String dataLogs) {
        this.dataLogs = dataLogs;
    }

    @XmlElement(name = "TimeSynchronize")
    public String getTimeSynchronize() {
        return timeSynchronize;
    }

    public void setTimeSynchronize(String timeSynchronize) {
        this.timeSynchronize = timeSynchronize;
    }

    @XmlElement(name = "EthernetPort")
    @XmlElementWrapper(name = "EthernetPorts")
    public List<EthernetPort> getEthernetPorts() {
        return ethernetPorts;
    }

    public void setEthernetPorts(List<EthernetPort> ethernetPorts) {
        this.ethernetPorts = ethernetPorts;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "name='" + name + '\'' +
                ", processorType='" + processorType + '\'' +
                ", majorRev='" + majorRev + '\'' +
                ", minorRev='" + minorRev + "\n\t" +
                "description='" + description + "\n\t" +
                "redundancyInfo='" + redundancyInfo + "\n\t" +
                "security='" + security + "\n\t" +
                "safetyInfo='" + safetyInfo + "\n\t" +
                "dataTypes=" + dataTypes + "\n\t" +
                "modules=" + modules + "\n\t" +
                "addOnInstructionDefinitions=" + addOnInstructionDefinitions + "\n\t" +
                "tags=" + tags + "\n\t" +
                "programs=" + programs + "\n\t" +
                "tasks=" + tasks + "\n\t" +
                "cst='" + cst + '\'' +
                "wallClockTime='" + wallClockTime + '\'' + "\n\t" +
                "trends=" + trends + "\n\t" +
                "dataLogs='" + dataLogs + '\'' +
                "timeSynchronize='" + timeSynchronize + '\'' + "\n\t" +
                "ethernetPorts=" + ethernetPorts +
                '}';
    }

    /**
     * Function return Program by part of Program name.
     * @param name name of program you want to get
     * @return Program or Optional.empty()
     */
    public Optional<Program> getProgramByName(String name) {
        return getProgramByName(name, 1);
    }

    /**
     * Function return Program by Program name.
     * @param name name of program you want to get
     * @param regex 0 - exact; 1 - contains
     * @return Program or Optional.empty()
     */
    public Optional<Program> getProgramByName(String name, int regex) {
        if (regex == 0) {
            for (Program program : programs) {
                if (program.getName().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))) {
                    return Optional.of(program);
                }
            }
        } else if (regex == 1) {
            for (Program program : programs) {
                if (program.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                    return Optional.of(program);
                }
            }
        }

        return Optional.empty();
    }
}
