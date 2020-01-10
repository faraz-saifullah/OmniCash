const express = require(`express`);
const router = express.Router();
const User = require(`../controller/user`)
const role = require(`../controller/auth`);

router.get(`/`, function (req, res, next) {
  res.redirect(`/signin`);
});

router.post(`/signup`, function (req, res, next) {
  User.newUser(req, res)
});
router.post(`/signin`, role.redirectHome, function (req, res) {
  User.login(req, res);
});

module.exports = router;
