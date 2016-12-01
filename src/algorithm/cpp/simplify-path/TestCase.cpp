#define BOOST_TEST_MAIN
#include <boost/test/included/unit_test.hpp>
#include <string>
#include <stack>
using namespace std;

#include "Solution.cpp"

struct global_fixture
{
    global_fixture()
    {
    }
    ~global_fixture()
    {
    }
};

BOOST_GLOBAL_FIXTURE(global_fixture);
struct assign_fixture
{
    assign_fixture()
    {
    }
    ~assign_fixture()
    {
    }
    Solution s;
};

BOOST_FIXTURE_TEST_SUITE(s_assign, assign_fixture)
BOOST_AUTO_TEST_CASE(t_assign_1)
{
    BOOST_CHECK_EQUAL(s.simplifyPath("/home"), "/home");
    BOOST_CHECK_EQUAL(s.simplifyPath("/home/"), "/home");
    BOOST_CHECK_EQUAL(s.simplifyPath("/a/./b/../../c/"), "/c");
    BOOST_CHECK_EQUAL(s.simplifyPath("/../"), "/");
    BOOST_CHECK_EQUAL(s.simplifyPath("/home//foo/"), "/home/foo");
    BOOST_CHECK_EQUAL(s.simplifyPath("////////"), "/");
}

BOOST_AUTO_TEST_SUITE_END()
