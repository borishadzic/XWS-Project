const ratings = require('../repository/ratings');

module.exports = function (context, req) {
    if (req.query.id) {
        ratings.approveComment(req.query.id).then(() => {
            context.res = {
                status: 200
            }

            context.done();
        });
    } else {
        context.res = {
            status: 400,
            body: "Please pass an id in the query string."
        };

        context.done();
    }
};