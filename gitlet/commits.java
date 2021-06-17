package gitlet;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Copyright@:
 *
 * @Author: Pan Zifeng
 * @Date: 2021/06/12/21:31
 * @Description:
 */
public class commits implements Serializable, Cloneable {

    /* the <message> : java main.java commit <message>*/
    private final String _LogMessage;
    /**
     * Fields
     */

    /* mapping from origin blob's name to the SHA-1 ID name */
    HashMap<String, String> blobs = new HashMap<>();
    /* mark the split point */
    private boolean splitPoint = false;

    public String get_CommitID() {
        return _CommitID;
    }

    public String get_LogMessage() {
        return _LogMessage;
    }

    public String get_ParentCommitID() {
        return _ParentCommitID;
    }

    public HashMap<String, String> getBlobs() {
        return blobs;
    }

    /**
     * Constructors
     */

    public commits(String _LogMessage) {
        this._LogMessage = _LogMessage;
        this._TimeStamp = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
    }

    public commits(String _ParentCommitID, String _LogMessage) {
        this(_LogMessage);
        this._ParentCommitID = _ParentCommitID;
    }

    /**
     * Getter and Setter Functions
     */

    public String get_TimeStamp() {
        return _TimeStamp;
    }

    public void set_TimeStamp(String _TimeStamp) {
        this._TimeStamp = _TimeStamp;
    }

    public void setBlobs(HashMap<String, String> blobs) {
        this.blobs = blobs;
    }

    public boolean isSplitPoint() {
        return splitPoint;
    }

    /* record the time */
    private String _TimeStamp;
    /* used to identify the commit record and generated by the hash function */
    private String _CommitID;
    /* linked to the parent commit by the ParentCommitID*/
    private String _ParentCommitID = null;

    public void setSplitPoint(boolean splitPoint) {
        this.splitPoint = splitPoint;
    }

    public void set_CommitID(String _CommitID) {
        this._CommitID = _CommitID;
    }
}
