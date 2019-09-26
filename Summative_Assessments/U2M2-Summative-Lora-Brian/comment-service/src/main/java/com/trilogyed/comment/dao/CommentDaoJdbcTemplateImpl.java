package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class CommentDaoJdbcTemplateImpl implements CommentDao {
    private static final String INSERT_COMMENT_SQL =
            "insert into comment (post_id, create_date, commenter_name, comment) values (?,?,?,?)";
    private static final String SELECT_COMMENT_SQL =
            "select from comment where comment_id = ?";
    private static final String SELECT_ALL_COMMENTS_SQL =
            "select * from comment";
    private static final String SELECT_COMMENTS_BY_COMMENTER_SQL =
            "select * from comment where commenter_name = ?";
    private static final String UPDATE_COMMENT_SQL =
            "update comment set post_id = ?, create_date = ?, commenter_name = ?, comment =? where comment_id = ?";
    private static final String DELETE_COMMENT_SQL =
            "delete from comment where comment_id = ?";


    private JdbcTemplate jdbcTemplate;

    public CommentDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Comment addComment(Comment comment) {
        jdbcTemplate.update(INSERT_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        comment.setCommentId(id);

        return comment;
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public List<Comment> getCommentsByCommenter(String commenterName) {
        return null;
    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void deleteComment(int id) {

    }
}
