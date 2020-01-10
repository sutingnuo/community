package com.suspringboot.frame.community.model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.id
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.parent_id
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private Long parent_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.com_type
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private Integer com_type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.commentator
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private Integer commentator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_create
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private Long gmt_create;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.gmt_modified
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private Long gmt_modified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.like_count
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private Long like_count;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.content
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.id
     *
     * @return the value of comment.id
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.id
     *
     * @param id the value for comment.id
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.parent_id
     *
     * @return the value of comment.parent_id
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public Long getParent_id() {
        return parent_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.parent_id
     *
     * @param parent_id the value for comment.parent_id
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.com_type
     *
     * @return the value of comment.com_type
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public Integer getCom_type() {
        return com_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.com_type
     *
     * @param com_type the value for comment.com_type
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setCom_type(Integer com_type) {
        this.com_type = com_type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.commentator
     *
     * @return the value of comment.commentator
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public Integer getCommentator() {
        return commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.commentator
     *
     * @param commentator the value for comment.commentator
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setCommentator(Integer commentator) {
        this.commentator = commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_create
     *
     * @return the value of comment.gmt_create
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public Long getGmt_create() {
        return gmt_create;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_create
     *
     * @param gmt_create the value for comment.gmt_create
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.gmt_modified
     *
     * @return the value of comment.gmt_modified
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public Long getGmt_modified() {
        return gmt_modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.gmt_modified
     *
     * @param gmt_modified the value for comment.gmt_modified
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setGmt_modified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.like_count
     *
     * @return the value of comment.like_count
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public Long getLike_count() {
        return like_count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.like_count
     *
     * @param like_count the value for comment.like_count
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setLike_count(Long like_count) {
        this.like_count = like_count;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.content
     *
     * @return the value of comment.content
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.content
     *
     * @param content the value for comment.content
     *
     * @mbg.generated Tue Jan 07 17:53:24 CST 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}