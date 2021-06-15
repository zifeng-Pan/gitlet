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
public class commits implements Serializable {
    /* mark the split point */
    private final boolean splitPoint = false;
    /* the <message> : java main.java commit <message>*/
    private final String _LogMessage;

    public String get_TimeStamp() {
        return _TimeStamp;
    }

    public String get_CommitID() {
        return _CommitID;
    }

    public void set_CommitID(String _CommitID) {
        this._CommitID = _CommitID;
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

    public void setBlobs(HashMap<String, String> blobs) {
        this.blobs = blobs;
    }

    /* mapping from origin blob's name to the SHA-1 ID name */
    HashMap<String, String> blobs = new HashMap<>();
    /* record the time */
    private String _TimeStamp;
    /* used to identify the commit record and generated by the hash function */
    private String _CommitID;
    /* linked to the parent commit by the ParentCommitID*/
    private String _ParentCommitID = null;

    public commits(String _LogMessage) {
        this._LogMessage = _LogMessage;
    }

    public commits(String _ParentCommitID, String _LogMessage) {
        this(_LogMessage);
        this._TimeStamp = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        this._ParentCommitID = _ParentCommitID;
    }
}